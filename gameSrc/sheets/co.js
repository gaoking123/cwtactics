/**
 * Database of co sheet objects.
 */
cwt.CoSheet = new cwt.SheetDatabase({
  schema: {
    type: 'object',
    required: ['ID'],
    properties: {
      ID: {
        type: 'isID'
      }
    }
  }
});