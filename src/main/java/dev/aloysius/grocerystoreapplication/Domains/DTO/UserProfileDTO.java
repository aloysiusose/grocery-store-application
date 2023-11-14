package dev.aloysius.grocerystoreapplication.Domains.DTO;

import java.time.LocalDate;

public record UserProfileDTO(String firstName,
                             String lastName,
                             String email,
                             String username,
                             LocalDate customerSince, int orderToDate
                             ) {
}
