package com.corp.globant.MODEL.dao;
import java.util.ArrayList;
import java.util.HashMap;
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
    public static DirContext getContext() throws NamingException{
        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://susexx.globant.com:389");
        env.put(Context.SECURITY_AUTHENTICATION,"simple");
        env.put(Context.SECURITY_PRINCIPAL, "CN=Ramiro Acoglanis,OU=Rosario,OU=Users,OU=Service_Desk,OU=OU_Infrastructure,OU=People,DC=globant,DC=com");
        env.put(Context.SECURITY_CREDENTIALS,"Batamanta1");
        //Conseguimos contexto de conexion
        DirContext ctx = new InitialDirContext(env);
        return ctx;
    }
    public static DirContext validateUser(String user,String passwd ) throws NamingException{

        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://susexx.globant.com:389");
        env.put(Context.SECURITY_AUTHENTICATION,"simple");
        env.put(Context.SECURITY_PRINCIPAL, LdapDAO.getCN(user));
        env.put(Context.SECURITY_CREDENTIALS,passwd);
        //Conseguimos contexto de conexion
        DirContext ctx = new InitialDirContext(env);
        return ctx;
    }
    
    public static String getCN (String user) throws NamingException{
        String search = "DC=globant,DC=com";
        SearchControls ctls = new SearchControls();
        ctls.setReturningObjFlag (true);
        //Asignamos los atributos a devolver
        ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
        DirContext ctx = LdapDAO.getContext();
        //Realiza la consulta, aplicando el filtro y trayendo los atributos especificados
        String filter = "(userPrincipalName=" + user + "@globant.com)";
        NamingEnumeration resultSet = ctx.search(search, filter, ctls);
        SearchResult result = (SearchResult) resultSet.next();
        LdapDAO.close(ctx);
        return result.getNameInNamespace();
        
    }

    public static ArrayList<String> getAtributes (String filter, String[] atr) throws NamingException{ 
        ArrayList<String> data = null;
        String search = "DC=globant,DC=com";
        SearchControls ctls = new SearchControls();
        // Para que devuelva los elementos que buscamos
        ctls.setReturningObjFlag (true);
        //Asignamos los atributos a devolver
        ctls.setReturningAttributes(atr);
        ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
        
        DirContext ctx = LdapDAO.getContext();
        //Realiza la consulta, aplicando el filtro y trayendo los atributos especificados
        NamingEnumeration resultSet = ctx.search(search, filter, ctls);

            
        while(resultSet.hasMore()){
            SearchResult result = (SearchResult) resultSet.next();
            for(String atributo : atr){
                data.add(result.getAttributes().get(atributo).get().toString());
                System.out.println(result.getAttributes().get(atributo).get().toString());
            }
        }
        LdapDAO.close(ctx);
        return data;
    }
    public static void close(DirContext ctx) {
        try {
            ctx.close();
        } catch (NamingException e) {
            // No se habia podido conectar, ya se habia cerrado la conexion, etc..
            e.printStackTrace();
        }
    }
}
