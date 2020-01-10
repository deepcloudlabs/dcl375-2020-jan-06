/**
 *
 * @author Binnur Kurt (binnur.kurt@gmail.com)
 *
 */
class WorldViewModel {
    API_URL = "http://localhost:7070/world/api";

    constructor() {
        this.continents = ko.observableArray([]);
        this.continent = ko.observable("Asia");
        this.countries = ko.observableArray([]);
        this.population = ko.computed(() =>
            this.countries().map(country => country.population).reduce((sum, pop) => sum + pop, 0)
        )
        this.populateContinents = this.populateContinents.bind(this);
        this.list = this.list.bind(this);
        this.populateContinents();
    }

    list() {
        fetch(`${this.API_URL}/countries?continent=${this.continent()}`).then(res => res.json()).then(countries => this.countries(countries))
    }

    populateContinents() {
        fetch(`${this.API_URL}/continents`).then(res => res.json()).then(continents => this.continents(continents));
    }

};

let wordViewModel = new WorldViewModel();

$(document).ready(function () {
    ko.applyBindings(wordViewModel);
});