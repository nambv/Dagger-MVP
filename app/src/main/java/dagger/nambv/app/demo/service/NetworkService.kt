package dagger.nambv.app.demo.service

import dagger.nambv.app.demo.model.Repo
import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable

interface NetworkService {

    @GET("users/{user}/repos")
    fun getRepoList(@Path("user") user: String): Observable<List<Repo>>

    @GET("/repos/{user}/{reponame}")
    fun getRepoItemDetails(@Path("user") user: String, @Path("reponame") repoName: String): Observable<Repo>

    companion object {
        val HTTPS_API_GITHUB_URL = "https://api.github.com/"
    }
}
