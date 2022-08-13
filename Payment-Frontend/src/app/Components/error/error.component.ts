import { Component, Input, OnInit, ViewEncapsulation } from '@angular/core';
import { NgbModal, NgbModalConfig } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-error',
  templateUrl: './error.component.html',
  encapsulation: ViewEncapsulation.None,
  styles: [`
  .dark-modal .modal-content {
    background-color: #292b2c;
    color: white;
  }
  .dark-modal .close {
    color: white;
  }
  .light-blue-backdrop {
    background-color: #5cb3fd;
  }
`]
})
export class ErrorComponent  {
  // @Input() error:any;

  // constructor(public config: NgbModalConfig, private modalService: NgbModal) {
  //   // customize default values of modals used by this component tree
  //   config.backdrop = 'static';
  //   config.keyboard = false;
  // }

  // openSm(content:any) {
  //   this.modalService.open(content, { size: 'sm' });
  // }
}

// import { Component } from '@angular/core';
// import { NgbModalConfig, NgbModal } from '@ng-bootstrap/ng-bootstrap';

// @Component({
//   selector: 'ngbd-modal-config',
//   templateUrl: './modal-config.html',
//   // add NgbModalConfig and NgbModal to the component providers
//   providers: [NgbModalConfig, NgbModal]
// })
// export class NgbdModalConfig {
//   constructor(config: NgbModalConfig, private modalService: NgbModal) {
//     // customize default values of modals used by this component tree
//     config.backdrop = 'static';
//     config.keyboard = false;
//   }

//   open(content) {
//     this.modalService.open(content);
//   }
// }