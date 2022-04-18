import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UnidadeSaveComponent } from './unidade-save.component';

describe('UnidadeSaveComponent', () => {
  let component: UnidadeSaveComponent;
  let fixture: ComponentFixture<UnidadeSaveComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UnidadeSaveComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UnidadeSaveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
