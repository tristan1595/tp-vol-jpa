package sopra.vol.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.PersistenceException;

import org.junit.Assert;
import org.junit.Test;

import sopra.vol.Application;
import sopra.vol.model.Reservation;
import sopra.vol.model.StatutReservation;
import sopra.vol.repository.IReservationRepository;

public class TestFlorian {

	@Test
	public void test1() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		IReservationRepository reservationRepo = Application.getInstance().getReservationRepo();
		Reservation resaP1 = new Reservation();
		resaP1.setNumero(461865);
		Date date = null;
		try {
			date = sdf.parse("25/06/2021");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		resaP1.setDtReservation(date);
		
		resaP1.setStatut(StatutReservation.CONFIRMER);
		
		
		resaP1 = reservationRepo.save(resaP1);
		
		Reservation resaFind = reservationRepo.findById(resaP1.getNumero());
		
		Assert.assertEquals(date, resaFind.getDtReservation());
		Assert.assertEquals(StatutReservation.CONFIRMER, resaFind.getStatut());
	}
	
	@Test
	public void test2() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		IReservationRepository reservationRepo = Application.getInstance().getReservationRepo();
		Reservation resaP1 = new Reservation();
		resaP1.setNumero(461865);
		Date date = null;
		try {
			date = sdf.parse("25/06/2021");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		resaP1.setDtReservation(date);
		resaP1.setStatut(StatutReservation.CONFIRMER);
		
		Reservation resaP2 = new Reservation();
		resaP2.setNumero(985467);
		Date date2 = null;
		try {
			date2 = sdf.parse("02/09/2021");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		resaP2.setDtReservation(date2);
		resaP2.setStatut(StatutReservation.ANNULER);


		Reservation resaP3 = new Reservation();
		resaP3.setNumero(800012);
		Date date3 = null;
		try {
			date3 = sdf.parse("13/01/2022");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		resaP3.setDtReservation(date3);
		resaP3.setStatut(StatutReservation.CONFIRMER);
		
		
	
		resaP1 = reservationRepo.save(resaP1);
		resaP2 = reservationRepo.save(resaP2);
		resaP3 = reservationRepo.save(resaP3);
		
		List<Reservation> resaFind = reservationRepo.findAll();
		
		Assert.assertEquals((Integer) 461865, resaFind.get(0).getNumero());
		Assert.assertEquals(date, resaFind.get(0).getDtReservation());
		Assert.assertEquals(StatutReservation.CONFIRMER, resaFind.get(0).getStatut());
		
		Assert.assertEquals((Integer) 985467, resaFind.get(2).getNumero());
		Assert.assertEquals(date2, resaFind.get(2).getDtReservation());
		Assert.assertEquals(StatutReservation.ANNULER, resaFind.get(2).getStatut());
		
		Assert.assertEquals((Integer) 800012, resaFind.get(1).getNumero());
		Assert.assertEquals(date3, resaFind.get(1).getDtReservation());
		Assert.assertEquals(StatutReservation.CONFIRMER, resaFind.get(1).getStatut());
	}
}
