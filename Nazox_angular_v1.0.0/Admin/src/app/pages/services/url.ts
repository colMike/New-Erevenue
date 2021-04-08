export class Urls {
    //private uri = 'otc/rest/v1';
    private uri = 'http://localhost:8080/revenueCollection/api';
    //private uri = "http://192.72.53.31:8090/compasotc/otc/rest/v1"

    get url(): string {
        return this.uri; // = 'http://localhost:9000/compasotc/otc/rest/v1' ;
    }

    // set url(uri: string) {
    //     this.uri = 'rest/v1';
    // }
}
