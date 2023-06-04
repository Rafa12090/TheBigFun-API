package com.crackelets.bigfun.platform.profile.api.rest;

import com.crackelets.bigfun.platform.profile.domain.service.OrganizerService;
import com.crackelets.bigfun.platform.profile.mapping.OrganizerMapper;
import com.crackelets.bigfun.platform.profile.resource.CreateOrganizerResource;
import com.crackelets.bigfun.platform.profile.resource.OrganizerResource;
import com.crackelets.bigfun.platform.profile.resource.UpdateOrganizerResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api/v1/organizers", produces="application/json")
public class OrganizersController {

    private OrganizerService organizerService;
    private OrganizerMapper mapper;


    public OrganizersController(OrganizerService organizerService, OrganizerMapper mapper) {
        this.organizerService = organizerService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<OrganizerResource> getAllOrganizers(Pageable pageable){
        return mapper.modelListPage(organizerService.getAll(),pageable);
    }

    @GetMapping("{organizerId}")          //"PathVariable": reconoce la variable de esta linea
    public OrganizerResource getOrganizerById(@PathVariable Long organizerId){
        return mapper.toResource(organizerService.getById(organizerId));
    }

    @PostMapping
    public ResponseEntity<OrganizerResource> createOrganizer(@RequestBody CreateOrganizerResource resource){

        return new ResponseEntity<>(mapper.toResource(organizerService.create(mapper.toModel(resource))), HttpStatus.CREATED);
    }

    @PutMapping("{organizerId}")
    public OrganizerResource updateOrganizer(@PathVariable Long organizerId,
                                         @RequestBody UpdateOrganizerResource resource){
        return mapper.toResource(organizerService.update(organizerId,mapper.toModel(resource)));
    }

    @DeleteMapping("{organizerId}")
    public ResponseEntity<?> deleteOrganizer(@PathVariable Long organizerId){
        return organizerService.delete(organizerId);
    }

}
