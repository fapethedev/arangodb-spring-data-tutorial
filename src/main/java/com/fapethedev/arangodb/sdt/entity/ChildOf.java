package com.fapethedev.arangodb.sdt.entity;

import com.arangodb.springframework.annotation.ArangoId;
import com.arangodb.springframework.annotation.Edge;
import com.arangodb.springframework.annotation.From;
import com.arangodb.springframework.annotation.To;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@ToString
@Getter
@Setter
@NoArgsConstructor
@Edge("childOf")
public class ChildOf
{
    @Id // db edge field: _key
    private String id;

    @ArangoId // db edge field: _id
    private String arangoId;

    @From(lazy = true) // edge source document(node): _from
    private Character from;

    @To(lazy = true) // edge destination document(node): _to
    private Character to;

    public ChildOf(Character from, Character to) {
        this.from = from;
        this.to = to;
    }
}
