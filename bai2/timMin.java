package note;

import java.util.ArrayList;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Scanner;

public class note {
	private String duongDi;
	private int sb;
	private char cot;
	private int hang;
	private int coHieu;
	private note trenTrai;
	private note duoiTrai;
	private note duoiPhai;
	private note trenPhai;

	public note[] taoBanCo() {
		note[] banco = new note[64];
		// ------------
		char[] hang = new char[8];
		for (int i = 65; i <= 72; i++) {
			hang[i - 65] = (char) i;
		}
		for (int i = 0; i <= 63; i++) {
			note co = new note();
			co.duongDi = " ";
			//co.soSanh = 100;
			co.sb = 0;
			co.coHieu = 0;
			co.duoiPhai = null;
			co.duoiTrai = null;
			co.trenPhai = null;
			co.trenTrai = null;
			co.cot = hang[i % 8];
			co.hang = 8 - i / 8;
			banco[i] = co;

		}
		// ------------
		for (int i = 0; i <= 63; i++) {
			if ((i + 1) % 8 == 1) {
				if (i == 56)
					continue;
				banco[i].duoiPhai = banco[i + 9];
				if (i > 7 && i < 56) {
					banco[i].trenPhai = banco[i - 7];
				}
				continue;
			}
			if ((i + 1) % 8 == 0) {
				if (i == 63)
					continue;
				banco[i].duoiTrai = banco[i + 7];
				if (i > 7 && i < 56) {
					banco[i].trenTrai = banco[i - 9];
				}
				continue;
			}
			if (i < 8) {
				banco[i].duoiTrai = banco[i + 7];
				banco[i].duoiPhai = banco[i + 9];
				continue;
			}
			if (i > 55) {
				banco[i].trenTrai = banco[i - 9];
				banco[i].trenPhai = banco[i - 7];
				continue;
			}
			banco[i].trenTrai = banco[i - 9];
			banco[i].duoiTrai = banco[i + 7];
			banco[i].duoiPhai = banco[i + 9];
			banco[i].trenPhai = banco[i - 7];
		}
		return banco;
	}

	// GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG//
	public String giaiThuat(note[] banco, note x, ArrayList<Integer> mang,ArrayList<String> ketQua) {
		if (x.trenTrai != null && x.trenTrai.coHieu == 0
				|| (x.trenTrai != null && x.trenTrai.coHieu == 2) && x.trenTrai.coHieu != 10) {

			if (x.trenTrai.coHieu == 2) {

				x.coHieu = 0;
				mang.add(x.sb + 1);
				ketQua.add(x.duongDi);
				return "";
			}
			x.trenTrai.duongDi = x.duongDi + "=>" + String.valueOf(x.trenTrai.cot) + String.valueOf(x.trenTrai.hang);
			x.trenTrai.sb = x.sb + 1;
			x.trenTrai.coHieu = 1;
			giaiThuat(banco, x.trenTrai, mang,ketQua);
		}
		if (x.duoiTrai != null && x.duoiTrai.coHieu == 0
				|| (x.duoiTrai != null && x.duoiTrai.coHieu == 2) && x.duoiTrai.coHieu != 10) {
			if (x.duoiTrai.coHieu == 2) {
				x.coHieu = 0;
				mang.add(x.sb + 1);
				ketQua.add(x.duongDi);
				return "";
			}
			x.duoiTrai.duongDi = x.duongDi + "=>" + String.valueOf(x.duoiTrai.cot) + String.valueOf(x.duoiTrai.hang);
			x.duoiTrai.sb = x.sb + 1;
			x.duoiTrai.coHieu = 1;
			giaiThuat(banco, x.duoiTrai, mang,ketQua);
		}
		if (x.duoiPhai != null && x.duoiPhai.coHieu == 0
				|| (x.duoiPhai != null && x.duoiPhai.coHieu == 2) && x.duoiPhai.coHieu != 10) {
			if (x.duoiPhai.coHieu == 2) {
				x.coHieu = 0;
				ketQua.add(x.duongDi);
				mang.add(x.sb + 1);
				return "";
			}
			
			x.duoiPhai.duongDi = x.duongDi + "=>" + String.valueOf(x.duoiPhai.cot) + String.valueOf(x.duoiPhai.hang);
			x.duoiPhai.sb = x.sb + 1;
			x.duoiPhai.coHieu = 1;
			giaiThuat(banco, x.duoiPhai, mang,ketQua);
		}
		if ((x.trenPhai != null && x.trenPhai.coHieu == 0)
				|| (x.trenPhai != null && x.trenPhai.coHieu == 2) && x.trenPhai.coHieu != 10) {
			if (x.trenPhai.coHieu == 2) {
				x.coHieu = 0;
				ketQua.add(x.duongDi);
				mang.add(x.sb + 1);
				return "";
			}
			
			x.trenPhai.duongDi = x.duongDi + "=>" + String.valueOf(x.trenPhai.cot) + String.valueOf(x.trenPhai.hang);
			x.trenPhai.sb = x.sb + 1;
			x.trenPhai.coHieu = 1;
			giaiThuat(banco, x.trenPhai, mang,ketQua);
		}
		x.coHieu = 0;
		return "ahihi";
	}

	public static void main(String[] args) {
		note[] banco = new note[64];
		note x = new note();
		banco = x.taoBanCo();
		
		//Nhap quan xuat phát lấy vị trí tính từ 0->63,từ trái qua phải từ trên xuống dưới
		banco[21].coHieu = 10;
		//Nhap quân cản thay số lượng 21 = ?d?d
		
		//banco[21].trenTrai.coHieu = 1;
		//banco[21].trenPhai.coHieu = 1;
		//banco[21].duoiTrai.coHieu = 1;
		banco[30].coHieu = 1;
		
		//Nhập quân đích
		banco[53].coHieu = 2;
		
		String min = new String();
		ArrayList<Integer> mang = new ArrayList<Integer>();
		ArrayList<String> ketQua = new ArrayList<String>();
		min = x.giaiThuat(banco, banco[21], mang,ketQua);

		
		int buocMin = mang.get(0);
		int len = mang.size();
		for(int i = 1;i < len;i++) {
			if(mang.get(i) <= buocMin) {
				buocMin = mang.get(i);
			}
		}
		for(int i = 0;i< len; i++) {
			if(buocMin == mang.get(i)) {
				System.out.println(ketQua.get(i));
			}
		}
		//System.out.println(buocMin);
	}
}

