package Core;

import java.io.File;

public class Core8080 {

        //System.load("D:\\IntelliJ Projects\\Emulator\\src\\libs\\i8080.dll");

    public Core8080() {
        String path = new File("i8080.dll").getAbsolutePath();
        System.load(path);
    }

    public native void i8080_init();
    public native int i8080_instruction();

    public native void i8080_jump(int addr);
    public native int i8080_pc();

    public native int i8080_regs_bc();
    public native int i8080_regs_de();
    public native int i8080_regs_hl();
    public native int i8080_regs_sp();

    public native int i8080_regs_a();
    public native int i8080_regs_b();
    public native int i8080_regs_c();
    public native int i8080_regs_d();
    public native int i8080_regs_e();
    public native int i8080_regs_h();
    public native int i8080_regs_l();

    public native int RD_BYTE(int addr);
    public native int RD_WORD(int addr);

    public native void WR_BYTE(int addr, int value);
    public native void WR_WORD(int addr, int value);
}
