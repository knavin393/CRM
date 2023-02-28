import { Size } from 'app/entities/enumerations/size.model';

export interface IProduct {
  id: number;
  name?: string | null;
  description?: string | null;
  price?: number | null;
  size?: Size | null;
  image?: string | null;
  imageContentType?: string | null;
}

export type NewProduct = Omit<IProduct, 'id'> & { id: null };
