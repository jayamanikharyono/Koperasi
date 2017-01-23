package org.pabwe.koperasi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Angsuran {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int idPinjaman;
	private String tanggalJatuhTempo;
	private String tanggalBayar;
	private double jumlah;
	
	@Column(nullable = true)
	private String keterangan;
	public Angsuran(int idPinjaman, String tanggalJatuhTempo, String tanggalBayar, double jumlah,
			String keterangan) {
		super();
		this.idPinjaman = idPinjaman;
		this.tanggalJatuhTempo = tanggalJatuhTempo;
		this.tanggalBayar = tanggalBayar;
		this.jumlah = jumlah;
		this.keterangan = keterangan;
	}
	public Angsuran() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdPinjaman() {
		return idPinjaman;
	}
	public void setIdPinjaman(int idPinjaman) {
		this.idPinjaman = idPinjaman;
	}
	public String getTanggalJatuhTempo() {
		return tanggalJatuhTempo;
	}
	public void setTanggalJatuhTempo(String tanggalJatuhTempo) {
		this.tanggalJatuhTempo = tanggalJatuhTempo;
	}
	public String getTanggalBayar() {
		return tanggalBayar;
	}
	public void setTanggalBayar(String tanggalBayar) {
		this.tanggalBayar = tanggalBayar;
	}
	public double getJumlah() {
		return jumlah;
	}
	public void setJumlah(double jumlah) {
		this.jumlah = jumlah;
	}
	public String getKeterangan() {
		return keterangan;
	}
	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}
	
}
