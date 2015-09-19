package com.corp.globant.MODEL.dao;
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
    public static DirContext getContext(String user, String passwd) throws NamingException{
        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://susexx.globant.com:389");
        env.put(Context.SECURITY_AUTHENTICATION,"simple");
        env.put(Context.SECURITY_PRINCIPAL, "ramiro.acoglanis");
        env.put(Context.SECURITY_CREDENTIALS,"Batamanta1");
        //Conseguimos contexto de conexion
        DirContext ctx = new InitialDirContext(env);
        return ctx;
    }
    public static void close(DirContext ctx) {
        try {
            ctx.close();
        } catch (NamingException e) {
            // No se habia podido conectar, ya se habia cerrado la conexion, etc..
            e.printStackTrace();
        }
    }

    public static void search (String cn, String filter, String[] atr) throws NamingException{ 
        
        SearchControls ctls = new SearchControls();
        // Para que devuelva los elementos que buscamos
        ctls.setReturningObjFlag (true);
        //Asignamos los atributos a devolver
        ctls.setReturningAttributes(atr);
        ctls.setSearchScope(SearchControls.SUBTREE_SCOPE);
        
        DirContext ctx = LdapDAO.getContext("ramiro.acoglanis", "Batamanta1");
        //Realiza la consulta, aplicando el filtro y trayendo los atributos especificados
        NamingEnumeration resultSet = ctx.search(cn,filter, ctls);
        while(resultSet.hasMore()){
            SearchResult result = (SearchResult) resultSet.next();
            for(String atributo : atr){
                System.out.println(result.getAttributes().get(atributo).get().toString());
            }
        }
        LdapDAO.close(ctx);
    }
}
