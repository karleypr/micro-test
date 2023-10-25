/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.0.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.test.micro.adapters.input.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-02-21T17:22:30.006331900+01:00[Europe/Paris]")
@Validated
@Tag(name = "price", description = "Operations about price")
public interface PriceApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /price/{productId} : Get price by
     * 
     *
     * @param productId The name of the product identifier. (required)
     * @param brandId The name of the brand identifier. (required)
     * @param applicationDate Application date. (required)
     * @return successful operation (status code 200)
     *         or Bad request (status code 400)
     *         or Price not found (status code 404)
     */
    @Operation(
        operationId = "getPriceBy",
        summary = "Get price by",
        tags = { "price" },
        responses = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = PriceDTO.class)),
                @Content(mediaType = "application/xml", schema = @Schema(implementation = PriceDTO.class))
            }),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "404", description = "Price not found")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/price/{productId}",
        produces = { "application/json", "application/xml" }
    )
    default ResponseEntity<PriceDTO> getPriceBy(
        @Parameter(name = "productId", description = "The name of the product identifier.", required = true) @PathVariable("productId") Integer productId,
        @NotNull @Parameter(name = "brandId", description = "The name of the brand identifier.", required = true) @Valid @RequestParam(value = "brandId", required = true) Integer brandId,
        @NotNull @Parameter(name = "applicationDate", description = "Application date.", required = true) @Valid @RequestParam(value = "applicationDate", required = true) String applicationDate
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"productId\" : 35455, \"endDate\" : \"2020-12-31 23.59.59\", \"price\" : 38.95, \"brandId\" : 1, \"startDate\" : \"2020-06-15 16.00.00\", \"priceList\" : 4 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/xml"))) {
                    String exampleString = "<null> <productId>35455</productId> <brandId>1</brandId> <priceList>4</priceList> <startDate>2020-06-15 16.00.00</startDate> <endDate>2020-12-31 23.59.59</endDate> <price>38.95</price> </null>";
                    ApiUtil.setExampleResponse(request, "application/xml", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
