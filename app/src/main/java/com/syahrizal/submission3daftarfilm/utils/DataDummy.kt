package com.syahrizal.submission3daftarfilm.utils

import com.syahrizal.submission3daftarfilm.data.source.local.entity.MovieEntity
import com.syahrizal.submission3daftarfilm.data.source.local.entity.TVShowEntity
import com.syahrizal.submission3daftarfilm.data.source.remote.response.movie.DetailMovieResponse
import com.syahrizal.submission3daftarfilm.data.source.remote.response.movie.MovieGenresItemResponse
import com.syahrizal.submission3daftarfilm.data.source.remote.response.movie.MovieProductionCompaniesItemResponse
import com.syahrizal.submission3daftarfilm.data.source.remote.response.movie.MoviesItemResponse
import com.syahrizal.submission3daftarfilm.data.source.remote.response.tvshow.DetailTVShowResponse
import com.syahrizal.submission3daftarfilm.data.source.remote.response.tvshow.TVShowGenresItemResponse
import com.syahrizal.submission3daftarfilm.data.source.remote.response.tvshow.TVShowProductionCompaniesItemResponse
import com.syahrizal.submission3daftarfilm.data.source.remote.response.tvshow.TVShowsItemResponse


object DataDummy {

    fun generateDummyMovies(): ArrayList<MovieEntity> {
        val movies = ArrayList<MovieEntity>()
        movies.add(
            MovieEntity(
                791373,
                "/tnAuB8q5vv7Ax9UAEje5Xi4BXik.jpg",
                "Zack Snyder's Justice League",
                "2021-03-18",
                "",
                12069.58,
                0,
                "",
                "Determined to ensure Superman's ultimate sacrifice was not in vain, Bruce Wayne aligns forces with Diana Prince with plans to recruit a team of metahumans to protect the world from an approaching threat of catastrophic proportions.",
                "",
                false
            )
        )
        movies.add(
            MovieEntity(
                373571,
                "/mzOHg7Q5q9yUmY0b9Esu8Qe6Nnm.jpg",
                "Godzilla vs. Kong",
                "2021-03-24",
                "",
                9329.285,
                0,
                "",
                "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
                "",
                false
            )
        )
        movies.add(
            MovieEntity(
                581389,
                "/1e1tUWInXCVrrwY6ntuNRuwEj7P.jpg",
                "Space Sweepers",
                "2021-02-05",
                "",
                4109.61,
                0,
                "",
                "When the crew of a space junk collector ship called The Victory discovers a humanoid robot named Dorothy that's known to be a weapon of mass destruction, they get involved in a risky business deal which puts their lives at stake.",
                "",
                false
            )
        )
        return movies
    }

    fun generateDummyTVShows(): ArrayList<TVShowEntity> {
        val tvShows = ArrayList<TVShowEntity>()
        tvShows.add(
            TVShowEntity(
                88396,
                "/qGA31gx01iIJMgk2MyVgurhCGeO.jpg",
                "The Falcon and the Winter Soldier",
                "2021-03-19",
                "",
                6482.293,
                0,
                "",
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                "",
                false
            )
        )
        tvShows.add(
            TVShowEntity(
                60735,
                "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                "The Flash",
                "2014-10-07",
                "",
                1510.931,
                0,
                "",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "",
                false
            )
        )
        tvShows.add(
            TVShowEntity(
                69050,
                "/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg",
                "Riverdale",
                "2017-01-26",
                "",
                1410.968,
                0,
                "",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                "",
                false
            )
        )
        return tvShows
    }

    fun generateDummyDetailMovie(movieId: Int): ArrayList<MovieEntity> {
        val detailMovie = ArrayList<MovieEntity>()
        detailMovie.add(
            MovieEntity(
                movieId,
                "/tnAuB8q5vv7Ax9UAEje5Xi4BXik.jpg",
                "Zack Snyder's Justice League",
                "2021-03-18",
                "Action, Adventure, Fantasy, Science Fiction",
                12069.58,
                87,
                "",
                "Determined to ensure Superman's ultimate sacrifice was not in vain, Bruce Wayne aligns forces with Diana Prince with plans to recruit a team of metahumans to protect the world from an approaching threat of catastrophic proportions.",
                "Warner Bros. Pictures (US), The Stone Quarry (US), Atlas Entertainment (US), DC Films (US), DC Entertainment (US), Access Entertainment, Dune Entertainment (US)"
            )
        )
        detailMovie.add(
            MovieEntity(
                movieId,
                "/mzOHg7Q5q9yUmY0b9Esu8Qe6Nnm.jpg",
                "Godzilla vs. Kong",
                "2021-03-24",
                "Action, Science Fiction",
                9329.285,
                71,
                "One Will Fall",
                "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
                "Warner Bros. Pictures (US), Legendary Pictures (US)"
            )
        )
        detailMovie.add(
            MovieEntity(
                movieId,
                "/1e1tUWInXCVrrwY6ntuNRuwEj7P.jpg",
                "Space Sweepers",
                "2021-02-05",
                "Drama, Fantasy, Science Fiction",
                4109.61,
                72,
                "2092, the space sweep begins!",
                "When the crew of a space junk collector ship called The Victory discovers a humanoid robot named Dorothy that's known to be a weapon of mass destruction, they get involved in a risky business deal which puts their lives at stake.",
                "Bidangil Pictures (KR), Merry Christmas (KR)"
            )
        )
        return detailMovie
    }

    fun generateDummyDetailTVShow(tvId: Int): ArrayList<TVShowEntity> {
        val detailTvShow = ArrayList<TVShowEntity>()
        detailTvShow.add(
            TVShowEntity(
                tvId,
                "/qGA31gx01iIJMgk2MyVgurhCGeO.jpg",
                "The Falcon and the Winter Soldier",
                "2021-03-19",
                "Sci-Fi & Fantasy, Action & Adventure, Drama",
                6482.293,
                72,
                "Honor the shield.",
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                "Marvel Studios (US)"
            )
        )
        detailTvShow.add(
            TVShowEntity(
                tvId,
                "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                "The Flash",
                "2014-10-07",
                "Drama, Sci-Fi & Fantasy",
                1510.931,
                77,
                "The fastest man alive.",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "Warner Bros. Television (US), Berlanti Productions (US), DC Entertainment (US), Mad Ghost Productions (US)"
            )
        )
        detailTvShow.add(
            TVShowEntity(
                tvId,
                "/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg",
                "Riverdale",
                "2017-01-26",
                "Mystery, Drama, Crime",
                1410.968,
                86,
                "Small town. Big secrets.",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                "Warner Bros. Television (US), Berlanti Productions (US)"
            )
        )
        return detailTvShow
    }

    fun generateRemoteDummyMoviesItem(): ArrayList<MoviesItemResponse> {
        val movies = ArrayList<MoviesItemResponse>()
        movies.add(
            MoviesItemResponse(
                "Determined to ensure Superman's ultimate sacrifice was not in vain, Bruce Wayne aligns forces with Diana Prince with plans to recruit a team of metahumans to protect the world from an approaching threat of catastrophic proportions.",
                "Zack Snyder's Justice League",
                "/tnAuB8q5vv7Ax9UAEje5Xi4BXik.jpg",
                "2021-03-18",
                791373,
                12069.58
            )
        )
        movies.add(
            MoviesItemResponse(
                "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
                "Godzilla vs. Kong",
                "/mzOHg7Q5q9yUmY0b9Esu8Qe6Nnm.jpg",
                "2021-03-24",
                373571,
                9329.285
            )
        )
        movies.add(
            MoviesItemResponse(
                "When the crew of a space junk collector ship called The Victory discovers a humanoid robot named Dorothy that's known to be a weapon of mass destruction, they get involved in a risky business deal which puts their lives at stake.",
                "Space Sweepers",
                "/1e1tUWInXCVrrwY6ntuNRuwEj7P.jpg",
                "2021-02-05",
                581389,
                4109.61
            )
        )
        return movies
    }

    fun generateRemoteDummyTVShowsItem(): ArrayList<TVShowsItemResponse> {
        val tvShows = ArrayList<TVShowsItemResponse>()
        tvShows.add(
            TVShowsItemResponse(
                "2021-03-19",
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                "/qGA31gx01iIJMgk2MyVgurhCGeO.jpg",
                "The Falcon and the Winter Soldier",
                88396,
                6482.293
            )
        )
        tvShows.add(
            TVShowsItemResponse(
                "2014-10-07",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                "The Flash",
                60735,
                1510.931
            )
        )
        tvShows.add(
            TVShowsItemResponse(
                "2017-01-26",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                "/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg",
                "Riverdale",
                69050,
                1410.968
            )
        )
        return tvShows
    }

    fun generateRemoteDummyDetailMovie(movieId: Int): ArrayList<DetailMovieResponse> {
        val detailMovie = ArrayList<DetailMovieResponse>()
        detailMovie.add(
            DetailMovieResponse(
                "Zack Snyder's Justice League",
                listOf(
                    MovieGenresItemResponse("Action"),
                    MovieGenresItemResponse("Adventure"),
                    MovieGenresItemResponse("Fantasy"),
                    MovieGenresItemResponse("Science Fiction")
                ),
                12069.58,
                movieId,
                "Determined to ensure Superman's ultimate sacrifice was not in vain, Bruce Wayne aligns forces with Diana Prince with plans to recruit a team of metahumans to protect the world from an approaching threat of catastrophic proportions.",
                "/tnAuB8q5vv7Ax9UAEje5Xi4BXik.jpg",
                listOf(
                    MovieProductionCompaniesItemResponse("Warner Bros. Pictures", "US"),
                    MovieProductionCompaniesItemResponse("The Stone Quarry", "US"),
                    MovieProductionCompaniesItemResponse("Atlas Entertainment", "US"),
                    MovieProductionCompaniesItemResponse("DC Films", "US"),
                    MovieProductionCompaniesItemResponse("DC Entertainment", "US"),
                    MovieProductionCompaniesItemResponse("Access Entertainment", ""),
                    MovieProductionCompaniesItemResponse("Dune Entertainment", "US")
                ),
                "2021-03-18",
                8.7,
                ""
            )
        )
        return detailMovie
    }

    fun generateRemoteDummyDetailTVShow(tvId: Int): ArrayList<DetailTVShowResponse> {
        val detailTvShow = ArrayList<DetailTVShowResponse>()
        detailTvShow.add(
            DetailTVShowResponse(
                listOf(
                    TVShowGenresItemResponse("Sci-Fi & Fantasy"),
                    TVShowGenresItemResponse("Action & Adventure"),
                    TVShowGenresItemResponse("Drama")
                ),
                6482.293,
                tvId,
                "2021-03-19",
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                "/qGA31gx01iIJMgk2MyVgurhCGeO.jpg",
                listOf(TVShowProductionCompaniesItemResponse("Marvel Studios", "US")),
                7.7,
                "The Falcon and the Winter Soldier",
                "Honor the shield."
            )
        )
        detailTvShow.add(
            DetailTVShowResponse(
                listOf(
                    TVShowGenresItemResponse("Drama"),
                    TVShowGenresItemResponse("Sci-Fi & Fantasy")
                ),
                1510.931,
                tvId,
                "2014-10-07",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                listOf(
                    TVShowProductionCompaniesItemResponse("Warner Bros. Television", "US"),
                    TVShowProductionCompaniesItemResponse("Berlanti Productions", "US"),
                    TVShowProductionCompaniesItemResponse("DC Entertainment", "US"),
                    TVShowProductionCompaniesItemResponse("Mad Ghost Productions", "US")
                ),
                7.7,
                "The Flash",
                "The fastest man alive."
            )
        )
        detailTvShow.add(
            DetailTVShowResponse(
                listOf(
                    TVShowGenresItemResponse("Mystery"),
                    TVShowGenresItemResponse("Drama"),
                    TVShowGenresItemResponse("Crime")
                ),
                1410.968,
                tvId,
                "2017-01-26",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                "/wRbjVBdDo5qHAEOVYoMWpM58FSA.jpg",
                listOf(
                    TVShowProductionCompaniesItemResponse("Warner Bros. Television", "US"),
                    TVShowProductionCompaniesItemResponse("Berlanti Productions", "US")
                ),
                8.6,
                "Riverdale",
                "Small town. Big secrets."
            )
        )
        return detailTvShow
    }
}
