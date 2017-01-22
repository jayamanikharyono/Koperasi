package org.pabwe.koperasi.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Anggota {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nama;
	private int idKtp;
	private String jK;
	private String alamat;
	private String kota;
	private String telepon;
	private double banyakSimpanan;
	private double banyakPinjaman;
	
	public Anggota() {
		super();
	}
	
	public Anggota(int id, String nama, int idKtp, String jK, String alamat, String kota, String telepon,
			double banyakSimpanan, double banyakPinjaman) {
		super();
		this.id = id;
		this.nama = nama;
		this.idKtp = idKtp;
		this.jK = jK;
		this.alamat = alamat;
		this.kota = kota;
		this.telepon = telepon;
		this.banyakSimpanan = banyakSimpanan;
		this.banyakPinjaman = banyakPinjaman;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public int getIdKtp() {
		return idKtp;
	}
	public void setIdKtp(int idKtp) {
		this.idKtp = idKtp;
	}
	public String getjK() {
		return jK;
	}
	public void setjK(String jK) {
		this.jK = jK;
	}
	public String getAlamat() {
		return alamat;
	}
	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
	public String getKota() {
		return kota;
	}
	public void setKota(String kota) {
		this.kota = kota;
	}
	public String getTelepon() {
		return telepon;
	}
	public void setTelepon(String telepon) {
		this.telepon = telepon;
	}
	public double getBanyakSimpanan() {
		return banyakSimpanan;
	}
	public void setBanyakSimpanan(double banyakSimpanan) {
		this.banyakSimpanan = banyakSimpanan;
	}
	public double getBanyakPinjaman() {
		return banyakPinjaman;
	}
	public void setBanyakPinjaman(double banyakPinjaman) {
		this.banyakPinjaman = banyakPinjaman;
	}
}
