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
	private double banyakSimpananWajib = 0;
	private double banyakSimpananSukarela = 0;
	private double banyakPinjaman = 0;
	
	public Anggota() {
		super();
	}
	public Anggota(String nama, int idKtp, String jK, String alamat, String kota, String telepon) {
		super();
		this.nama = nama;
		this.idKtp = idKtp;
		this.jK = jK;
		this.alamat = alamat;
		this.kota = kota;
		this.telepon = telepon;
	}


	public double getBanyakSimpananWajib() {
		return banyakSimpananWajib;
	}


	public void setBanyakSimpananWajib(double banyakSimpananWajib) {
		this.banyakSimpananWajib = banyakSimpananWajib;
	}


	public double getBanyakSimpananSukarela() {
		return banyakSimpananSukarela;
	}


	public void setBanyakSimpananSukarela(double banyakSimpananSukarela) {
		this.banyakSimpananSukarela = banyakSimpananSukarela;
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
	public double getBanyakPinjaman() {
		return banyakPinjaman;
	}
	public void setBanyakPinjaman(double banyakPinjaman) {
		this.banyakPinjaman = banyakPinjaman;
	}
}
