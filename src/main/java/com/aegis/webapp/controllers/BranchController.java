package com.aegis.webapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aegis.webapp.entities.Branch;
import com.aegis.webapp.entities.Room;
import com.aegis.webapp.repository.BranchRepository;
import com.aegis.webapp.repository.RoomRepository;

@Controller
public class BranchController {
	
	@Autowired
	BranchRepository branchRepository;
	
	@Autowired
	RoomRepository roomRepository;

	@RequestMapping(value = "/admin/branch", method = RequestMethod.GET)
	public String branchPage(Model model,@RequestParam(value = "id",required = false) Long id,@RequestParam(value = "true",required = false) Long branchId) {
        model.addAttribute("id",id);
		if(id == null) {
			List<Branch> branches = branchRepository.findAll();
			model.addAttribute("branches",branches);
		} else {
			Branch branches = branchRepository.findByBranchId(id);
			List<Room> rooms = roomRepository.findAllByBranchId(branches.getBranchId());
			model.addAttribute("branches",branches);
			model.addAttribute("rooms",rooms);
		}
		if(branchId != null) {
			Branch branch = branchRepository.findByBranchId(branchId);
			branch.setStatus(!branch.isStatus());
			branchRepository.save(branch);
			return "redirect:/admin/branch";
		}
        return "branchPage";
    }
	
	@RequestMapping(value = "/admin/branch/add", method = RequestMethod.GET)
	public String branchPage(Model model,Branch branch) {
        
		model.addAttribute("branch",branch);
        return "addBranchPage";
    }
	
	@RequestMapping(value = "/admin/branch/add", method = RequestMethod.POST)
	public String saveBranch(Model model,Branch branch,BindingResult bindingResult) {
        Branch branchExists = branchRepository.findByAddress(branch.getAddress());
        if(branchExists != null) {
        	bindingResult.reject("branchExists");
        	model.addAttribute("error","Branch Already Exists!");
        } else {
        	branchRepository.save(branch);
        	model.addAttribute("success","Branch successfully saved!");
        }
        return "addBranchPage";
    }
	
	@RequestMapping(value = "/admin/branch/room", method = RequestMethod.GET)
	public String addRoomPage(Model model,Branch branch,Room room,@RequestParam(value = "id",required = false) Long id) {
		model.addAttribute("id",id);
		model.addAttribute("room",room);
		model.addAttribute("branch",branch);
        return "addRoomPage";
    }
	
	@RequestMapping(value = "/admin/branch/room", method = RequestMethod.POST)
	public String saveRoomPage(Model model,Branch branch,Room room,BindingResult bindingResult,@RequestParam(value = "id",required = false) Long id) {
		Room roomExist = roomRepository.findByTypeAndBranchId(room.getType(),room.getBranchId());
		if(roomExist != null) {
        	bindingResult.reject("branchExists");
        	model.addAttribute("error","Room Already Exists!");
        } else {
        	room.setBranchId(id);
        	room.setStatus(true);
        	roomRepository.save(room);
        	model.addAttribute("success","Room successfully saved!");
        }
		model.addAttribute("room",room);
		model.addAttribute("branch",branch);
        return "addRoomPage";
    }

	
	
	
}
