package com.corp.globant.GLBAPI;
import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
/**
 *
 * @author ramiro.acoglanis
 */
public class LdapDAO {
        
    
    public static DirContext connectToLDAP(String url, String user, String password) throws NamingException{
        Hashtable<String, String> env = new Hashtable<String, String>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, url);
        env.put(Context.SECURITY_AUTHENTICATION,"simple");
        env.put(Context.SECURITY_PRINCIPAL, user);
        env.put(Context.SECURITY_CREDENTIALS,password);
        //Conseguimos contexto de conexion
        DirContext ctx = new InitialDirContext(env);
        return ctx;
    }
    public static void closeConnectionToLDAP(DirContext ctx) {
        try {
            ctx.close();
        } catch (NamingException e) {
            // No se habia podido conectar, ya se habia cerrado la conexion, etc..
            e.printStackTrace();
        }
    }

    public static void buscar (String user, DirContext ctx) throws NamingException{ 
        //Recordar que el username tiene que tener toda la ruta de OUs/DCs/CNs
        
        SearchControls ctls = new SearchControls();
        ctls. setReturningObjFlag (true); // Para que devuelva los elementos que buscamos

        String returning[] = new String[2];
        returning[0] = "mail";
        returning[1] = "cn";
        //Asignamos los atributos a devolver
        ctls.setReturningAttributes(returning);
        ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);

//        String search = user; // Search es "en donde buscar" de los directorios del servidor
//        String filter = "name=" + user; // filtro trivial
        String search = "DC=globant,DC=com"; // Search es "en donde buscar" de los directorios del servidor
        String filter = "(userPrincipalName=ramiro.acoglanis@globant.com)";// filtro trivial
        
        NamingEnumeration answer = ctx.search(search,filter, ctls);       	
        SearchResult result = (SearchResult) answer.next(); // Sabemos que habra un solo resultado
        String field1 = result.getAttributes().get("mail").get().toString();
        String field2 = result.getAttributes().get("cn").get().toString();
        System.out.println(user + ": " + field1 + ", " + field2);
 }

}
