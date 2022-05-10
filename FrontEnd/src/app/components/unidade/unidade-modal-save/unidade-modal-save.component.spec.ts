import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UnidadeModalSaveComponent } from './unidade-modal-save.component';

describe('UnidadeModalSaveComponent', () => {
  let component: UnidadeModalSaveComponent;
  let fixture: ComponentFixture<UnidadeModalSaveComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UnidadeModalSaveComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UnidadeModalSaveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
