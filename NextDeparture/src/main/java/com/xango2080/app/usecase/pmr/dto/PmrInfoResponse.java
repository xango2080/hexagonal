package com.xango2080.app.usecase.pmr.dto;

import java.util.ArrayList;
import java.util.Collection;

public class PmrInfoResponse {

	Collection<TrainDTO> trains = new ArrayList<>();

	private boolean serviceUnavailable;
}
