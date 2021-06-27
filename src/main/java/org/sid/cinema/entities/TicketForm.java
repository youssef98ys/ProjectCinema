package org.sid.cinema.entities;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class TicketForm {
	private String nomClient;
	private int codepayement;
	private List<Long> tickets=new ArrayList<Long>();
}
