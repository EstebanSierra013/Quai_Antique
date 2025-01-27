import { Category } from "./category";

export interface Dish {
  idDish: number;
  title: string;
  description: string;
  prix: number;
  category: Category;
  imageUrl: string;
}