package dagger.nambv.app.demo.service;

import java.util.List;

import dagger.nambv.app.demo.model.Repo;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface NetworkService {

    String HTTPS_API_GITHUB_URL = "https://api.github.com/";

    @GET("users/{user}/repos")
    Observable<List<Repo>> getRepoList(@Path("user") String user);

    @GET("/repos/{user}/{reponame}")
    Observable<Repo> getRepoItemDetails(@Path("user") String user, @Path("reponame") String repoName);
}
