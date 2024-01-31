import java.io.FileWriter;
import java.io.File;
class Main{
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
}
public static void main(String[] args){
    FileWriter output = new FileWriter(new File("compiled.ll")); //Create the file to which we should output the llvm code
    output.write(PREAMBLE); //This goes before the generated code

    output.write(POSTAMBLE); //This goes after the generated code
}