package org.sid.cinema.web;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.sid.cinema.dao.TicketRepository;
import org.sid.cinema.entities.Ticket;
import org.sid.cinema.entities.TicketForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.Data;

@CrossOrigin("*")
@org.springframework.web.bind.annotation.RestController
public class CinemaRestController3 {
	@Autowired
	private TicketRepository ticketRepository;
	
	@PostMapping("/payerTicket")
	@Transactional
	public List<Ticket> payerTicket(@RequestBody TicketForm ticketForm) {
		List<Ticket> listTickets=new ArrayList<>();
		ticketForm.getTickets().forEach(id->{
			Ticket ticket =ticketRepository.findById(id).get();
			ticket.setNomClient(ticketForm.getNomClient());
			ticket.setReserve(true);
			ticket.setCodePayement(ticketForm.getCodepayement());
			ticketRepository.save(ticket);
			listTickets.add(ticket);
		}
		);
		return listTickets;
	}
	
	
}

