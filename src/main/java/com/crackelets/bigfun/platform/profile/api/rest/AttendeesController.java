package com.crackelets.bigfun.platform.profile.api.rest;

import com.crackelets.bigfun.platform.profile.domain.service.AttendeeService;
import com.crackelets.bigfun.platform.profile.mapping.AttendeeMapper;
import com.crackelets.bigfun.platform.profile.resource.AttendeeResource;
import com.crackelets.bigfun.platform.profile.resource.CreateAttendeeResource;
import com.crackelets.bigfun.platform.profile.resource.UpdateAttendeeResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/attendees")
public class AttendeesController {

    private final AttendeeService attendeeService;
    private final AttendeeMapper mapper;

    public AttendeesController(AttendeeService attendeeService, AttendeeMapper mapper) {
        this.attendeeService = attendeeService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<AttendeeResource> getAllAttendees(Pageable pageable) {
        return mapper.modelListPage(attendeeService.getAll(), pageable);
    }

    @GetMapping("{attendeeId}")
    public AttendeeResource getStudentById(@PathVariable Long attendeeId) {
        return mapper.toResource(attendeeService.getById(attendeeId));
    }

    @PostMapping  // To create
    public ResponseEntity<AttendeeResource> createStudent(CreateAttendeeResource resource) {
        return new ResponseEntity<>(mapper.toResource(attendeeService.create(mapper.toModel(resource))), HttpStatus.CREATED);
    }

    @PutMapping("{attendeeId}")  // Update
    public AttendeeResource updateStudent(@PathVariable Long attendeeId, @RequestBody UpdateAttendeeResource resource) {
        return mapper.toResource(attendeeService.update(attendeeId, mapper.toModel(resource)));
    }

    @DeleteMapping("{attendeeId}")
    public ResponseEntity<?> deleteAttendee(@PathVariable Long attendeeId) {
        return attendeeService.delete(attendeeId);
    }

}
