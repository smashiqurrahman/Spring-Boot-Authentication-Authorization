package com.ashiq.security_app.demo;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    @Operation(
            description = "Get end point for admin",
            summary = "This is a summary for admin end point",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Unauthorized/Invalid Token",
                            responseCode = "403"
                    )
            }
    )
    @GetMapping
    @PreAuthorize("hasAnyAuthority('admin:read')")
    public String get() {
        return "GET:: admin controller";
    }

    @PreAuthorize("hasAnyAuthority('admin:create')")
    @PostMapping
    public String post() {
        return "POST:: admin controller";
    }

    @PreAuthorize("hasAnyAuthority('admin:update')")
    @PutMapping
    public String put() {
        return "PUT:: admin controller";
    }

    @PreAuthorize("hasAnyAuthority('admin:delete')")
    @DeleteMapping
    public String delete() {
        return "DELETE:: admin controller";
    }

}
