package com.aegis.webapp.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "jadwal_booking")
public class Booking {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)   
	@Column(name = "id_jadwal")
	private Long bookingId;
	
	@Column(name = "user_id")
	private Long userId;
	
	@Column(name = "id_kamar")
	private Long roomId;
	
	@Column(name = "id_jam")
	private Long hourId;
	
	@Column(name = "tanggal_booking",columnDefinition="DATE")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date bookingDate;
	
	@Column(name = "tanggal_transaksi")
	private Date transactionDate;
	
	@Column(name = "id_movie")
	private Long movieId;
	
	@Column(name = "status")
	private boolean status;
	
	
	public Booking() {
		super();
	}

	public Booking(Long bookingId, Long userId, Long roomId, Long hourId, Date bookingDate, Date transactionDate,Long movieId,boolean status) {
		super();
		this.bookingId = bookingId;
		this.userId = userId;
		this.roomId = roomId;
		this.hourId = hourId;
		this.bookingDate = bookingDate;
		this.transactionDate = transactionDate;
		this.movieId = movieId;
		this.status = status;
	}

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	public Long getHourId() {
		return hourId;
	}

	public void setHourId(Long hourId) {
		this.hourId = hourId;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
}
