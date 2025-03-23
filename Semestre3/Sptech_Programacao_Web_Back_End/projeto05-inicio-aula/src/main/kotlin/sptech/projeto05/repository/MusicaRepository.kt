package sptech.projeto05.repository

import org.springframework.data.jpa.repository.JpaRepository
import sptech.projeto05.entity.Musica

interface MusicaRepository: JpaRepository<Musica, Int> {
}


