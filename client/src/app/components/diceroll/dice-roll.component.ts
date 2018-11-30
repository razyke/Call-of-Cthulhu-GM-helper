import { Component, Input } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
    selector: 'dice-roll',
    templateUrl: './dice-roll.component.html',
    styleUrls: ['./dice-roll.component.css']
})
export class DiceRollComponent {
    
    private rollDiceServiceUrl: string = "http://localhost:8080/diceroll"

    public diceType: string = "d100";
    public diceCount: number = 1;

    constructor(private http: HttpClient) { }

    performRoll() {
        let rollDiceString = this.diceCount + "x" + this.diceType
        this.http.post(this.rollDiceServiceUrl, {rollRequest: rollDiceString})
            .subscribe(result => console.log(result));
    }
}