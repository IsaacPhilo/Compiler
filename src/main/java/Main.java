import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static final String PREAMBLE = "; ModuleID = 'examples/test1'\n" +
            "source_filename = \"examples/test1\"\n" +
            "target datalayout = \"e-m:e-p270:32:32-p271:32:32-p272:64:64-i64:64-f80:128-n8:16:32:64-S128\"\n" +
            "target triple = \"x86_64-pc-linux-gnu\"\n" +
            "\n" +
            "@print_int_fstring = private unnamed_addr constant [4 x i8] c\"%d\\0A\\00\", align 1\n" +
            "\n" +
            "; Function Attrs: noinline nounwind optnone uwtable\n" +
            "define dso_local i32 @main() #0 {\n";

    public static final String POSTAMBLE = "    ret i32 0\n" +
            "}\n" +
            "\n" +
            "declare i32 @printf(i8*, ...) #1\n" +
            "\n" +
            "attributes #0 = { noinline nounwind optnone uwtable \"frame-pointer\"=\"all\" \"min-legal-vector-width\"=\"0\" \"no-trapping-math\"=\"true\" \"stack-protector-buffer-size\"=\"8\" \"target-cpu\"=\"x86-64\" \"target-features\"=\"+cx8,+fxsr,+mmx,+sse,+sse2,+x87\" \"tune-cpu\"=\"generic\" }\n" +
            "attributes #1 = { \"frame-pointer\"=\"all\" \"no-trapping-math\"=\"true\" \"stack-protector-buffer-size\"=\"8\" \"target-cpu\"=\"x86-64\" \"target-features\"=\"+cx8,+fxsr,+mmx,+sse,+sse2,+x87\" \"tune-cpu\"=\"generic\" }\n" +
            "\n" +
            "!llvm.module.flags = !{!0, !1, !2, !3, !4}\n" +
            "!llvm.ident = !{!5}\n" +
            "\n" +
            "!0 = !{i32 1, !\"wchar_size\", i32 4}\n" +
            "!1 = !{i32 7, !\"PIC Level\", i32 2}\n" +
            "!2 = !{i32 7, !\"PIE Level\", i32 2}\n" +
            "!3 = !{i32 7, !\"uwtable\", i32 1}\n" +
            "!4 = !{i32 7, !\"frame-pointer\", i32 2}\n" +
            "!5 = !{!\"Ubuntu clang version 10.0.0-4ubuntu1\"}";

    public static void main(String[] args) {//the command-line argument should be the file-name. No decision yet on whether we need the absolute path.
        testReflection();
//        FileWriter output = null; //Create the file to which we should output the llvm code
//        boolean interpret = false;
//        try {
//            output = new FileWriter(new File("compiled.ll"));
//            output.write(Main.PREAMBLE); //This goes before the generated code
//            output.write(Main.POSTAMBLE); //This goes after the generated code
//
//            Scanner sc = null;
//            if(args.length > 0){
//                sc = new Scanner(new File(args[0]));
//                compileFile(sc, output);
//            }
//            else {
//                sc = new Scanner(System.in);
//                interpret = true;
//                interpretInput(sc, output);
//            }
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }

    public static void compileFile(Scanner sc, FileWriter output){

    }

    public static void interpretInput(Scanner sc, FileWriter output){//I'll hold off on this

    }

    public static void testReflection(){
        List<ASTNode> testList = new ArrayList<>();
        testList.add(new ASTPlus());
        testList.add(new ASTMinus());
        testList.add(new ASTDivide());
        testList.add(new ASTInt("100"));
        for(ASTNode n: testList) {
            System.out.println("Content: " + n.getContent());

            /*
            Calling static methods with RTTI:
            I have written my code in such a way
            that everything extending ASTNode
            has a getRegex() and isOperator() method.
            I want to retain these as static methods
            so that they can be accessed without
            creating any instances of their classes,
            but I can't create an instance method of
            the same name as the static method, so
            I will use reflection here
             */
            try {
                Class nodeClass = n.getClass();

                Method getRegex = nodeClass.getMethod("getRegex", null);
                System.out.println("Regex: " + getRegex.invoke(null, null));

                Method isOperator = nodeClass.getMethod("isOperator", null);
                System.out.println("Is an operator: " + ((Boolean) isOperator.invoke(null, null) ? "yes" : "no"));
            } catch (Exception e) {
                System.out.println("ERROR: " + e.toString());
            }
            System.out.println("-------");
        }
    }

}