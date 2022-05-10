import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UnidadeModalDeleteComponent } from './unidade-modal-delete.component';

describe('UnidadeModalDeleteComponent', () => {
  let component: UnidadeModalDeleteComponent;
  let fixture: ComponentFixture<UnidadeModalDeleteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UnidadeModalDeleteComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UnidadeModalDeleteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
