class MusicaFixture {
    companion object {
        fun umaMusica(): Musica {
            val clazz = Musica::class.java
            val musica = clazz.getDeclaredConstructor().newInstance()

            clazz.getDeclaredField("id").let {
                it.isAccessible = true
                it.set(musica, 1)
            }

            clazz.getDeclaredField("titulo").let {
                it.isAccessible = true
                it.set(musica, "Bohemian Rhapsody")
            }

            clazz.getDeclaredField("artista").let {
                it.isAccessible = true
                it.set(musica, "Queen")
            }

            clazz.getDeclaredField("album").let {
                it.isAccessible = true
                it.set(musica, "A Night at the Opera")
            }

            clazz.getDeclaredField("duracao").let {
                it.isAccessible = true
                it.set(musica, 354)
            }

            clazz.getDeclaredField("disponivel").let {
                it.isAccessible = true
                it.set(musica, true)
            }

            return musica
        }

        fun musicaAtualizacao() : Musica {
            val clazz = Musica::class.java
            val musica = clazz.getDeclaredConstructor().newInstance()

            clazz.getDeclaredField("id").let {
                it.isAccessible = true
                it.set(musica, 1)
            }

            clazz.getDeclaredField("titulo").let {
                it.isAccessible = true
                it.set(musica, "Another One Bites the Dust")
            }

            clazz.getDeclaredField("artista").let {
                it.isAccessible = true
                it.set(musica, "Queen")
            }

            clazz.getDeclaredField("album").let {
                it.isAccessible = true
                it.set(musica, "The Game")
            }

            clazz.getDeclaredField("duracao").let {
                it.isAccessible = true
                it.set(musica, 216)
            }

            clazz.getDeclaredField("disponivel").let {
                it.isAccessible = true
                it.set(musica, false)
            }

            return musica
        }
    }
}