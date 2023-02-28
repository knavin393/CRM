import dayjs from 'dayjs/esm';

import { OrderStatus } from 'app/entities/enumerations/order-status.model';

import { IProductOrder, NewProductOrder } from './product-order.model';

export const sampleWithRequiredData: IProductOrder = {
  id: 84064,
  placedDate: dayjs('2023-02-04T21:28'),
  status: OrderStatus['CANCELLED'],
  code: 'sticky',
};

export const sampleWithPartialData: IProductOrder = {
  id: 28058,
  placedDate: dayjs('2023-02-05T10:52'),
  status: OrderStatus['COMPLETED'],
  code: 'Fort',
  invoiceId: 'Intelligent',
};

export const sampleWithFullData: IProductOrder = {
  id: 24086,
  placedDate: dayjs('2023-02-05T03:21'),
  status: OrderStatus['PENDING'],
  code: 'Checking Officer Investor',
  invoiceId: 'Integration Wisconsin',
};

export const sampleWithNewData: NewProductOrder = {
  placedDate: dayjs('2023-02-04T22:41'),
  status: OrderStatus['PENDING'],
  code: 'South Incredible',
  id: null,
};

Object.freeze(sampleWithNewData);
Object.freeze(sampleWithRequiredData);
Object.freeze(sampleWithPartialData);
Object.freeze(sampleWithFullData);
