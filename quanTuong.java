package bai2;

import java.util.*;

public class quanTuong {

    private boolean check ;
    private char[] viTri = new char[2];
    private char[] nuocDi = new char[2];
    public void nhapViTri(){
        Scanner inp = new Scanner(System.in);
        String viTri;
        while (true){
            System.out.println("Nhap vi tri a1->a8,g1->g8");
            viTri = inp.nextLine();
            this.viTri = viTri.toCharArray();
            if(this.viTri.length > 2) {
                continue;
            }
            if(this.viTri[0] >= 97 && this.viTri[0] <= 103)
                if(this.viTri[1] >= 49 && this.viTri[1] <= 56 )
                    break;
        }
    }
    public boolean nhapNuocDi() {
        Scanner inp = new Scanner(System.in);
        String nuocDi;
        while (true) {
            System.out.println("Nhap Nuoc Di a1->a8,g1->g8");
            nuocDi = inp.nextLine();
            this.nuocDi = nuocDi.toCharArray();
            if (this.nuocDi.length > 2) {
                continue;
            }
            if (this.nuocDi[0] >= 97 && this.nuocDi[0] <= 104)
                if (this.nuocDi[1] >= 49 && this.nuocDi[1] <= 56) {
                    if(this.nuocDi[0] == this.viTri[0]) {
                        System.out.println("ko thoa ma");
                        check = false;
                        break;
                    }
                    else
                    {
                        int a = this.viTri[0]>this.nuocDi[0]?this.viTri[0] - this.nuocDi[0]:this.nuocDi[0] - this.viTri[0];
                        int b = this.viTri[1]>this.nuocDi[1]?this.viTri[1] - this.nuocDi[1]:this.nuocDi[1] - this.viTri[1];
                        if(a == b){
                            System.out.println("thoa ma");
                            check = true;
                            break;
                        }
                        System.out.println("ko thoa ma");
                        check =false;
                        break;
                    }
                }
        }

        return check;
    }


    public static void main(String[] args) {
        quanTuong qt1 = new quanTuong();
        qt1.nhapViTri();
        qt1.nhapNuocDi();

    }
}
