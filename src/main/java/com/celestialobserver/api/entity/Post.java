package com.celestialobserver.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "posts")
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "celestial_body", nullable = false)
    private String celestialBody;

    @Column(name = "equipment")
    private String equipment;

    @Column(name = "created_at", nullable = false)
    private String createdAt;

    @Column(name = "atmosphere_condition")
    private String atmosphereCondition;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "observation_location", nullable = false)
    private String location;

    @Column(name = "image_url")
    private String imageUrl;

}
