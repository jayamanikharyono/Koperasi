package org.pabwe.koperasi.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Simpanan {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Integer idAnggota;
	private String namaAnggota;
	private String tglSimpanan;
	private String tipeSimpanan;
	private double simpanan;
	private String ket;
	
	
	
	public Simpanan() {
		super();
	}
	public Simpanan(Integer id, Integer idAnggota, String namaAnggota, String tglSimpanan, String tipeSimpanan,
			double simpanan, String ket) {
		super();
		this.id = id;
		this.idAnggota = idAnggota;
		this.namaAnggota = namaAnggota;
		this.tglSimpanan = tglSimpanan;
		this.tipeSimpanan = tipeSimpanan;
		this.simpanan = simpanan;
		this.ket = ket;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdAnggota() {
		return idAnggota;
	}
	public void setIdAnggota(Integer idAnggota) {
		this.idAnggota = idAnggota;
	}
	public String getNamaAnggota() {
		return namaAnggota;
	}
	public void setNamaAnggota(String namaAnggota) {
		this.namaAnggota = namaAnggota;
	}
	public String getTglSimpanan() {
		return tglSimpanan;
	}
	public void setTglSimpanan(String tglSimpanan) {
		this.tglSimpanan = tglSimpanan;
	}
	public String getTipeSimpanan() {
		return tipeSimpanan;
	}
	public void setTipeSimpanan(String tipeSimpanan) {
		this.tipeSimpanan = tipeSimpanan;
	}
	public double getSimpanan() {
		return simpanan;
	}
	public void setSimpanan(double simpanan) {
		this.simpanan = simpanan;
	}
	public String getKet() {
		return ket;
	}
	public void setKet(String ket) {
		this.ket = ket;
	}
	

	
}
