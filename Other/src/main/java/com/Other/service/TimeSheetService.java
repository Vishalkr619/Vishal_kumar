package com.Other.service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

import javax.management.relation.RoleNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Other.model.TimeSheet;
import com.Other.repository.TimeSheetRepository;

@Service
public class TimeSheetService {

	@Autowired
	private TimeSheetRepository timeSheetRepository;

	public TimeSheetService(TimeSheetRepository timeSheetRepository)
	{
		this.timeSheetRepository = timeSheetRepository;
	}
	
	//Get method
	public List<TimeSheet> getAllTimeSheets()
	{
		return timeSheetRepository.findAll();
	}
	
	//Get By Id
	public TimeSheet getTimeSheetById(int id) throws RoleNotFoundException
	{
		return timeSheetRepository.findById(id)
									.orElseThrow(() -> new RoleNotFoundException("progress not found with id "+id));
	}
	
	//Create method
	public TimeSheet createTimeSheet(TimeSheet timeSheet)
	{
		return timeSheetRepository.save(timeSheet);
	}
	
	//Put By Id
	public TimeSheet updateTimeSheetById(int id, TimeSheet updateTimeSheet)
	{
		TimeSheet timeSheet = timeSheetRepository.findById(id).get();
		
		timeSheet.setId(updateTimeSheet.getId());
		timeSheet.setUser(updateTimeSheet.getUser());
		timeSheet.setTask(updateTimeSheet.getTask());
		timeSheet.setProject(updateTimeSheet.getProject());
		timeSheet.setDate(updateTimeSheet.getDate());
		timeSheet.setInvoiced(updateTimeSheet.getInvoiced());
		timeSheet.setTime(updateTimeSheet.getTime());
		
		return timeSheetRepository.save(timeSheet);
	}
	
	//Delete method
	public void deleteTimeSheetById(int id) throws Exception
	{
		if(!timeSheetRepository.existsById(id))
		{
			throw new UserPrincipalNotFoundException("progress not found with id "+id);
		}
		
		timeSheetRepository.deleteById(id);
	}
	
}
