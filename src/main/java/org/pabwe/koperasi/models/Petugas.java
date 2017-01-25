package org.pabwe.koperasi.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Petugas {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String nama;
	private String alamat;
	private String kota;
	private String jK;
	private String noHP;
	
	public Petugas() {
		super();
	}
	
	public Petugas(int id, String nama, String alamat, String kota, String jK, String noHP) 
	{
		super();
		this.id = id;
		this.nama = nama;
		this.alamat = alamat;
		this.kota = kota;
		this.jK = jK;
		this.noHP = noHP;
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
	public String getjK() {
		return jK;
	}
	public void setjK(String jK) {
		this.jK = jK;
	}
	public String getNoHP() {
		return noHP;
	}
	public void setNoHP(String noHP) {
		this.noHP = noHP;
	}
}
