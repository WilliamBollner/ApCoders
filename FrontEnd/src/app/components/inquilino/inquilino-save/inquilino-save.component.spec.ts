import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InquilinoSaveComponent } from './inquilino-save.component';

describe('InquilinoSaveComponent', () => {
  let component: InquilinoSaveComponent;
  let fixture: ComponentFixture<InquilinoSaveComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InquilinoSaveComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InquilinoSaveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
