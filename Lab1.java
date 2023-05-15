package Lab4Tuan4;

import java.util.ArrayList;
import java.util.Scanner;

class GiaoDich {
private String MaGD, NgayGD;
private double DonGia;
private float DienTich;
Scanner sc = new Scanner(System.in);
public GiaoDich(){
super();
}
public GiaoDich(String MaGD, String NgayGD,double DonGia, float DienTich){
super();
this.MaGD = MaGD;
this.NgayGD = NgayGD;
this.DonGia = DonGia;
this.DienTich = DienTich;
}
public String getMaGD() {
    return MaGD;
}
public void setMaGD(String maGD) {
    MaGD = maGD;
}
public String getNgayGD() {
    return NgayGD;
}
public void setNgayGD(String ngayGD) {
    NgayGD = ngayGD;
}
public double getDonGia() {
    return DonGia;
}
public void setDonGia(double donGia) {
    DonGia = donGia;
}
public float getDienTich() {
    return DienTich;
}
public void setDienTich(float dienTich) {
    DienTich = dienTich;
}

public void nhap(){
System.out.println("Nhap ma giao dich");
MaGD = sc.nextLine();
System.out.println("Nhap ngay giao dich (ngay/thang/nam): ");
NgayGD = sc.nextLine();
System.out.println("Nhap don gia: ");
DonGia = sc.nextDouble();
System.out.println("Nhap dien tich: ");
DienTich = sc.nextFloat();
}
@Override
public String toString() {
    return "GiaoDich [MaGD=" + MaGD + ", NgayGD=" + NgayGD + ", DonGia=" + DonGia + ", DienTich=" + DienTich + ", sc="
            + sc + "]";
}

}
class GiaoDichDat extends GiaoDich{
private String LoaiDat;
public GiaoDichDat(){
super();
}
public GiaoDichDat(String LoaiDat){
this.LoaiDat = LoaiDat;

}
public String getLoaiDat() {
    return LoaiDat;
}
public void setLoaiDat(String loaiDat) {
    LoaiDat = loaiDat;
}
public void nhap(){
super.nhap();
System.out.println("Nhap loai dat A/B/C: ");
LoaiDat = sc.nextLine();
}
@Override
public String toString() {
    return "GiaoDichDat [LoaiDat=" + LoaiDat + "]";
}
}
class GiaoDichNha extends GiaoDich{
private String LoaiNha, DiaChi;
private int chon;
public GiaoDichNha(){
super();
}
public GiaoDichNha(String LoaiNha, String DiaChi){
super();
this.LoaiNha = LoaiNha;
this.DiaChi = DiaChi;
}
public String getLoaiNha() {
    return LoaiNha;
}
public void setLoaiNha(String loaiNha) {
    LoaiNha = loaiNha;
}
public String getDiaChi() {
    return DiaChi;
}
public void setDiaChi(String diaChi) {
    DiaChi = diaChi;
}
public void nhap(){
super.nhap();
System.out.println("Nhap dia chi: ");
DiaChi = sc.nextLine();
System.out.println("Nhap loai nha (0: cao cap, 1: thuong: )");
chon = sc.nextInt();
switch(chon){
case 0:
LoaiNha = "cao cap";
break;
case 1:
LoaiNha = "thuong";
break;
default:
System.out.println("Khong hop le");
break;
}
}
@Override
public String toString() {
    return "GiaoDichNha [LoaiNha=" + LoaiNha + ", DiaChi=" + DiaChi + ", chon=" + chon + "]";
}
}
class Main{
public static void main(String[] args) {
ArrayList<GiaoDichNha> arrGDNha = new ArrayList<>();
ArrayList<GiaoDichDat> arrGDDat = new ArrayList<>();
int soGDDat = 0, soGDNha = 0;
long tongTienGDDat = 0, trungBinhThanhTien = 0;
Scanner sca = new Scanner(System.in);

System.out.println("Nhap so giao dich dat: ");
soGDDat = sca.nextInt();
System.out.println("Nhap so giao dich nha: ");
soGDNha = sca.nextInt();

System.out.println("Nhap thong tin giao dich dat: ");
for (int i = 0; i < soGDDat; i++){
System.out.println("Nhap thong tin giao dich dat thu" +(i+1)+":");
GiaoDichDat GDDat = new GiaoDichDat();
GDDat.nhap();
arrGDDat.add(GDDat);
}

System.out.println("Nhap thong tin giao dich nha: ");
for (int i = 0; i < soGDNha; i++){
System.out.println("Nhap thong tin giao dich nha thu" +(i+1)+":");
GiaoDichNha GDNha = new GiaoDichNha();
GDNha.nhap();
arrGDNha.add(GDNha);
}

System.out.println("---Thong tin giao dich dat---");
for (int i=0; i < arrGDNha.size();i++){
System.out.println(arrGDDat.get(i).toString());
}

System.out.println("---Thong tin giao dich nha---");
for (int i=0; i < arrGDNha.size();i++){
System.out.println(arrGDNha.get(i).toString());
}
for (int i = 0; i<arrGDDat.size();i++){
if (arrGDDat.get(i).getLoaiDat().equalsIgnoreCase("A")){
    tongTienGDDat += arrGDDat.get(i).getDienTich()*arrGDDat.get(i).getDonGia()*1.5;
}
else if (arrGDDat.get(i).getLoaiDat().equalsIgnoreCase("B") || 
arrGDDat.get(i).getLoaiDat().equalsIgnoreCase("C")) 
{
    tongTienGDDat += arrGDDat.get(i).getDienTich()*arrGDDat.get(i).getDonGia();
}
}
trungBinhThanhTien = tongTienGDDat / (arrGDDat.size());
        System.out.println("Trung binh thanh tien cua giao dich dat = " + trungBinhThanhTien);
         
        System.out.println("Cac giao dich dat cua thang 9/2013: ");
        for (int i = 0; i < arrGDDat.size(); i++) {
            String[] dateGiaoDichDat = arrGDDat.get(i).getNgayGD().split("/");
            if (dateGiaoDichDat[1].equals("9") && dateGiaoDichDat[2].equals("2013")) {
                System.out.println(arrGDDat.get(i).toString());
            }
        }
         
        System.out.println("Cac giao dich nha cua thang 9/2013: ");
        for (int i = 0; i < arrGDNha.size(); i++) {
            String[] dateGiaoDichNha = arrGDNha.get(i).getNgayGD().split("/");
            if (dateGiaoDichNha[1].equals("9") && dateGiaoDichNha[2].equals("2013")) {
                System.out.println(arrGDNha.get(i).toString());
            }
}
}
}
