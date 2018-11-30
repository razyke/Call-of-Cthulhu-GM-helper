import { DiceRollComponent } from "./dice-roll.component";
import { TestBed } from '@angular/core/testing';
import { HttpClient, HttpClientModule }    from '@angular/common/http';
import { FormsModule } from '@angular/forms';

describe('DiceRollComponent', () => {
    let component: DiceRollComponent;

    beforeEach(() => {
        TestBed.configureTestingModule({
            declarations: [DiceRollComponent],
            imports: [HttpClientModule, FormsModule]
        });
        component = TestBed.createComponent(DiceRollComponent).componentInstance;
    });

    it(' should successfully roll dice', () => {
        component.performRoll();
    })
})