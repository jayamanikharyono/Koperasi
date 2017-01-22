package org.pabwe.koperasi.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pinjaman {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private int idAnggota;
	private String namaAnggota;
	private double jumlahPinjaman;
	private String tanggalPinjam;
	private String waktu;
	private double angsuranPokok; //total yang harus dibayar perbulan
	private String status;
	private String ket;
	private double angsuranTotal; //total yang harus dibayar;
	
	public Pinjaman() {
		super();
	}
	
	public Pinjaman(int id, int idAnggota, String namaAnggota, double jumlahPinjaman, String tanggalPinjam,
			String waktu, double angsuranPokok, String status, String ket, double angsuranTotal) {
		super();
		this.id = id;
		this.idAnggota = idAnggota;
		this.namaAnggota = namaAnggota;
		this.jumlahPinjaman = jumlahPinjaman;
		this.tanggalPinjam = tanggalPinjam;
		this.waktu = waktu;
		this.angsuranPokok = angsuranPokok;
		this.status = status;
		this.ket = ket;
		this.angsuranTotal = angsuranTotal;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdAnggota() {
		return idAnggota;
	}
	public void setIdAnggota(int idAnggota) {
		this.idAnggota = idAnggota;
	}
	public String getNamaAnggota() {
		return namaAnggota;
	}
	public void setNamaAnggota(String namaAnggota) {
		this.namaAnggota = namaAnggota;
	}
	public double getJumlahPinjaman() {
		return jumlahPinjaman;
	}
	public void setJumlahPinjaman(double jumlahPinjaman) {
		this.jumlahPinjaman = jumlahPinjaman;
	}
	public String getTanggalPinjam() {
		return tanggalPinjam;
	}
	public void setTanggalPinjam(String tanggalPinjam) {
		this.tanggalPinjam = tanggalPinjam;
	}
	public String getWaktu() {
		return waktu;
	}
	public void setWaktu(String waktu) {
		this.waktu = waktu;
	}
	public double getAngsuranPokok() {
		return angsuranPokok;
	}
	public void setAngsuranPokok(double angsuranPokok) {
		this.angsuranPokok = angsuranPokok;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getKet() {
		return ket;
	}
	public void setKet(String ket) {
		this.ket = ket;
	}
	public double getAngsuranTotal() {
		return angsuranTotal;
	}
	public void setAngsuranTotal(double angsuranTotal) {
		this.angsuranTotal = angsuranTotal;
	}
}
