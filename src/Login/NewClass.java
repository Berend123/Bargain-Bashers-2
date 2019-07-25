/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;
class A{
  static String name="old";
}
class B{
 void changename(String newname){
  A.name = newname; 
 }
}
class C{
 String getname(){
 return A.name;
 }
}
public class NewClass{
 public static void main(String args[]){
   B b = new B();
   b.changename("Berend");
   C c = new C();
   System.out.println("getName returned "+c.getname());
 }
}