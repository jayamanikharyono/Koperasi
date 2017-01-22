package org.pabwe.koperasi.models;

import javax.persistence.Entity;

@Entity
public class Angsuran {
	private int id;
	private int idPinjaman;
	private String tanggalJatuhTempo;
	private String tanggalBayar;
	private double jumlah;
	private String keterangan;
}
