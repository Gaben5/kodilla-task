package com.crud.tasks.trello.client;

import com.crud.tasks.domain.TrelloBoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.*;

@Component
@RequiredArgsConstructor
public class TrelloClient {
    private final RestTemplate restTemplate;

    @Value("${trello.api.endpoint.prod}")
    private String trelloApiEndpoint;
    @Value("${trello.api.key}")
    private String trellopAppKey;
    @Value("${trello.app.token}")
    private String trelloToken;
    @Value("${trello.username}")
    private String trelloUsername;

    private URI urlBoard(){
        return UriComponentsBuilder.fromHttpUrl(trelloApiEndpoint + "/members/"+ trelloUsername +"/boards")
                .queryParam("key",trellopAppKey)
                .queryParam("token", trelloToken)
                .queryParam("fields","id,name")
                .queryParam("lists", "all")
                .build()
                .encode()
                .toUri();
    }
    public List<TrelloBoardDto> getTrelloBoards() {
        TrelloBoardDto[] boardsResponse = restTemplate.getForObject(urlBoard(),TrelloBoardDto[].class);

        return Optional.ofNullable(boardsResponse)
                .map(Arrays::asList)
                .orElse(Collections.emptyList());
    }

}
