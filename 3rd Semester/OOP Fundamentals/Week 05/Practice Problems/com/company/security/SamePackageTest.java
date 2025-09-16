package com.company.security;

public class SamePackageTest{
    public static void testAccess(){
        AccessModifierDemo demo=new AccessModifierDemo(5,"World",15.7,false);

        System.out.println("------ Access from SamePackageTest ------");
        // System.out.println(demo.privateField);
        System.out.println(demo.defaultField);
        System.out.println(demo.protectedField);
        System.out.println(demo.publicField);

        // demo.privateMethod();
        demo.defaultMethod();
        demo.protectedMethod();
        demo.publicMethod();
    }
}
