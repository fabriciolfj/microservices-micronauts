package com.github.fabriciolfj.controller;

import com.github.fabriciolfj.business.FindInventory;
import com.github.fabriciolfj.business.SaveInventory;
import com.github.fabriciolfj.controller.dto.InventoryRequestEntranceDTO;
import com.github.fabriciolfj.controller.dto.InventoryRequestExitDTO;
import com.github.fabriciolfj.controller.mapper.InventoryDTOMapper;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller("/api/v1/inventories")
public class InventoryController {

    private final SaveInventory saveInventory;
    private final FindInventory findInventory;

    @Post("/exit")
    public HttpResponse createExit(final InventoryRequestExitDTO dto) {
        var inv = saveInventory.save(InventoryDTOMapper.toEntity(dto));
        var resp = InventoryDTOMapper.toResponse(inv);

        return HttpResponse.created(resp);
    }

    @Post("/entrance")
    public HttpResponse createEntrance(final InventoryRequestEntranceDTO dto) {
        var inv = saveInventory.save(InventoryDTOMapper.toEntity(dto));
        var resp = InventoryDTOMapper.toResponse(inv);

        return HttpResponse.created(resp);
    }

    @Get("/{code}")
    public HttpResponse find(@PathVariable("code") final String code) {
        var inv = findInventory.findByCode(code);
        var resp = InventoryDTOMapper.toResponse(inv);

        return HttpResponse.ok(resp);
    }
}
