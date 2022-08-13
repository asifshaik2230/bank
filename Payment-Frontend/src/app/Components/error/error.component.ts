import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-error',
  templateUrl: './error.component.html',
  providers: [NgbModalConfig, NgbModal],
  styleUrls: ['./error.component.css']
})
export class ErrorComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

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