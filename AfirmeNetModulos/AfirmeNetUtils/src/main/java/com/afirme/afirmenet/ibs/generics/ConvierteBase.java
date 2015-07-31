package com.afirme.afirmenet.ibs.generics;

import java.util.Vector;

/*
 * Created on 13-ene-2008
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author rafa TODO To change the template for this generated type comment go to Window - Preferences - Java - Code Style - Code Templates
 */
public class ConvierteBase
{
   public static Vector<Object> vbase30 = new Vector<Object>();
   public static Vector<Object> vbase36 = new Vector<Object>();
   public static Vector<Object> vbase20 = new Vector<Object>();

   static
   {
      // creacion de la tabla en base 30 y 36
      for(int i = 0; i <= 9; i++)
      {
         vbase30.add(i, String.valueOf(i));
         vbase36.add(i, String.valueOf(i));
      }
      byte v = 9;
      byte v2 = 9;
      for(char c = 'A'; c <= 'Z'; c++)
      {
         vbase36.add((int) ++v2, String.valueOf(c));
         if(c != 'G' && c != 'I' && c != 'L' && c != 'O' && c != 'S')
         {
            vbase30.add((int) ++v, String.valueOf(c));
         }
      }
      // creacion de base 20 para la validación
      // de la fecha de la línea de captura

      byte v3 = 1;
      vbase20.add(0, "");
      // cargando la base 20
      for(char c = 'A'; c <= 'Z'; c++)
      {
         if(c != 'G' && c != 'I' && c != 'L' && c != 'O' && c != 'S' && c != 'Z')
         {
            vbase20.add(v3++, String.valueOf(c));
         }
      }

   }

   /**
    **Método que convierte de base 30 a base 10
    */
   public static double convertB30ToB10(String strbase30)
   {
      String cadena = strbase30.toUpperCase();
      double valor = 0;
      byte b = 30;
      // new ConvierteBase();
      for(int i = cadena.length() - 1, j = 0; i >= 0; i--, j++)
      {
         if(vbase30.contains("" + (cadena.charAt(i))))
         {
            valor += (vbase30.indexOf("" + (cadena.charAt(i)))) * Math.pow(b, j);
         }
         else
            return 0;
      }
      return valor;
   }

   /**
    **Método que convierte de base 36 a base 10
    */
   public static double convertB36ToB10(String strbase36)
   {
      String cadena = strbase36.toUpperCase();
      double valor = 0;
      byte b = 36;

      for(int i = cadena.length() - 1, j = 0; i >= 0; i--, j++)
      {
         if(vbase36.contains("" + (cadena.charAt(i))))
         {
            valor += (vbase36.indexOf("" + (cadena.charAt(i)))) * Math.pow(b, j);
         }
         else
            return 0;
      }
      return valor;
   }

   /**
    **Método que convierte de base 10 a base 30
    */
   public static String convertB10ToB30(double dbase10)
   {
      String miBase30 = "";

      Double d = new Double(dbase10);
      int division = d.intValue();
      int residuo = 0;
      // miBase30="";

      while(division > 0)
      {
         residuo = (int) (division % 30);
         division = division / 30;
         miBase30 = vbase30.get((int) (residuo)) + miBase30;
      }

      return miBase30;
   }

   /*
    * @Método que decodifica la fecha de línea de captura
    */
   public static String decodeB20(String fechaLinCap)
   {
      String cadena = "";
      for(int i = 0; i < fechaLinCap.length(); i++)
      {
         int numero = 0;
         String caracter = String.valueOf(fechaLinCap.charAt(i));
         if(Character.isDigit(fechaLinCap.charAt(i)))
         {
            // Si es numero entonces buscar su equivalencia en la tabla b20
            try
            {
               numero = Integer.valueOf(caracter).intValue();
            }
            catch (Exception e)
            {
               e.printStackTrace();
            }
            cadena += vbase20.get(numero);
         }
         else
         {
            cadena += fechaLinCap.charAt(i);
         }
      }
      return cadena;
   }
}
